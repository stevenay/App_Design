package net.naylinaung.appdesign.data.agents.retrofit;

import net.naylinaung.appdesign.data.responses.CourseListResponse;
import net.naylinaung.appdesign.utils.AppDesignConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by NayLinAung on 9/22/16.
 */
public interface CourseApi {

    @FormUrlEncoded
    @POST(AppDesignConstants.API_GET_COURSE_LIST)
    Call<CourseListResponse> loadCourses(
            @Field(AppDesignConstants.PARAM_ACCESS_TOKEN) String param);

}
