package net.naylinaung.appdesign.data.agents.retrofit;

import net.naylinaung.appdesign.data.agents.CourseDataAgent;
import net.naylinaung.appdesign.data.models.CourseModel;
import net.naylinaung.appdesign.data.responses.CourseListResponse;
import net.naylinaung.appdesign.utils.AppDesignConstants;
import net.naylinaung.appdesign.utils.CommonInstances;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aung on 7/9/16.
 */
public class RetrofitDataAgent implements CourseDataAgent {

    private static RetrofitDataAgent objInstance;

    private final CourseApi theApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDesignConstants.COURSE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(CourseApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadCourses() {
        Call<CourseListResponse> loadAttractionCall = theApi.loadCourses(AppDesignConstants.ACCESS_TOKEN);
        loadAttractionCall.enqueue(new Callback<CourseListResponse>() {
            @Override
            public void onResponse(Call<CourseListResponse> call, Response<CourseListResponse> response) {
                CourseListResponse courseListResponse = response.body();
                if (courseListResponse == null) {
                    CourseModel.getInstance().notifyErrorInLoadingAttractions(response.message());
                } else {
                    CourseModel.getInstance().notifyAttractionsLoaded(courseListResponse.getCourseList());
                }
            }

            @Override
            public void onFailure(Call<CourseListResponse> call, Throwable throwable) {
                CourseModel.getInstance().notifyErrorInLoadingAttractions(throwable.getMessage());
            }
        });
    }

}
