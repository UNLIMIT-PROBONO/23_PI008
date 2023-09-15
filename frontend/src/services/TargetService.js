import { URI } from "../utils/config";
import RestAPI from "../utils/AxiosApi";
import {
  jsonToAllTaregetInfomation,
  jsonToTargetInfomation,
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
      return {}
    })
    .catch((error) => {
      console.log(error);
      return {};
    });
};
