import RestAPI from "../utils/AxiosApi";
import { URI } from "../utils/config";
import { jsonToUsageForm } from "../mapper/managementTargetMapper";

export const getTargetUsage = async (targetId) => {
  return await RestAPI.get(URI.DATA + `/usage/${targetId}`)
    .then((res) => {
      if (res.status === 200) {
        return jsonToUsageForm(res.data);
      }
    })
    .catch((error) => {
      console.log(error);
      return {};
    });
};

export const getDangerousTargetsUsage = async () => {
  return await RestAPI.get(URI.USER_DANGER)
  .then((res)=> {
    if(res.status === 200){
      // FIXME
      return [];
    }
  }).catch((error)=>{
    console.log(error);
    return [];
  })
}