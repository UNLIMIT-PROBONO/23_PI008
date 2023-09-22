import { URI } from "../utils/config";
import RestAPI from "../utils/AxiosApi";

export const sendLoginForm = async (data) => {
  return await RestAPI.post(URI.LOGIN, data)
    .then((res) => {
      if (res.status === 200) {
        return true;
      } else if (res.status === 400) {
        return false;
      }
    })
    .catch((error) => {
      return false;
    });
};

export const checkIdVerification = async (loginId) => {
  var uri = URI.CHECK_ID;

  return await RestAPI.get(uri + `${loginId}`)
    .then((response) => {
      if (response.status === 200) return true;
      else return false;
    })
    .catch((error) => {
      return false;
    });
};

export const sendSignUpForm = async (userData) => {
  var uri = URI.SIGNUP;

  return await RestAPI.post(uri, userData)
    .then((res) => {
      if (res.status === 201) {
        console.log(userData.loginId + "님이 회원가입 했습니다.");
        return true;
      }
      return false;
    })
    .catch((error) => {
      return false;
    });
};

export const sendLogout = async () => {
  return await RestAPI.post(URI.LOGOUT)
    .then((res) => {
      if (res.status === 200) return true;
      return false;
    })
    .catch((error) => {
      return false;
    });
};
