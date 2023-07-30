import { URI } from "../utils/config";
import RestAPI from "../utils/AxiosApi";

export const sendLoginForm = async (data) => {
  var result = false;

  result = await RestAPI.post(URI.LOGIN, data)
    .then((res) => {
      if (res.status === 200) {
        console.log(data.login_id + "님이 로그인 했습니다.");
        return true;
      } else if (res.status === 400) {
        return false;
      }
    })
    .catch((error) => console.log(error));

  return result;
};

export const checkIdVerification = async (loginId) => {
  var uri = URI.CHECK_ID;
  var result = false;

  result = await RestAPI.get(uri + `${loginId}`)
    .then((response) => {
      if (response.status === 200) return true;
      else if (response.status === 409) return false;
    })
    .catch((error) => console.log(error));

  return result;
};

export const sendSignUpForm = async (userData) => {
  var uri = URI.SIGNUP;

  await RestAPI.post(uri, userData)
    .then((res) => {
      if (res.status === 201) {
        console.log(userData.loginId + "님이 회원가입 했습니다.");
      }
    })
    .catch((error) => console.log(error));
};
