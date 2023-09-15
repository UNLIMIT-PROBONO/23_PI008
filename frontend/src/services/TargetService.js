import { URI } from "../utils/config";
import RestAPI from "../utils/AxiosApi";
import {
  jsonToAllTaregetInfomation,
  jsonToTargetInfomation,
  jsonToUsageForm,
} from "../mapper/managementTargetMapper";

export const getAllTargetInfo = async () => {
  return await RestAPI.get(URI.MANAGEMENT_TARGET)
    .then((res) => {
      if (res.status === 200) {
        return jsonToAllTaregetInfomation(res.data);
      } else if(res.status === 401){
        return []
      }
    })
    .catch((error) => {
      console.log(error);
      return [];
    });
};

export const getTargetInfo = async (targetId) => {
  return await RestAPI.get(URI.MANAGEMENT_TARGET + `/${targetId}`)
    .then((res) => {
      if (res.status === 200) {
        return jsonToTargetInfomation(res.data);
      }
    })
    .catch((error) => {
      console.log(error);
      return [];
    });
};

export const getTargetUsage = async (targetId) => {
  return await RestAPI.get(URI.MANAGEMENT_TARGET + `/${targetId}/usage`)
    .then((res) => {
      if (res.status === 200) {
        return jsonToUsageForm(res.data);
      }
    })
    .catch((error) => {
      console.log(error);
    });
};

