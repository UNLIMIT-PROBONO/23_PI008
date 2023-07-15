import { jsonToHistoryOfSchedule } from "../mapper/scheduleMapper";
import RestAPI from "../utils/AxiosApi";
import { URI } from "../utils/config";

export async function getAfterTodaysSchedules() {
  const result = await RestAPI.get(URI.SCHEDULE)
    .then((res) => {
      if (res.status === 200) {
        return res.data;
      }
    })
    .catch((e) => console.log(e));
  return result;
}

export async function getHistoryOfSchedule(targetId) {
  var result = await RestAPI.get(URI.SCHEDULE_HISTORY, {
    params: {
      user_id: targetId,
    },
  })
    .then((res) => {
      if (res.status === 200) {
        return jsonToHistoryOfSchedule(res.data);
      }
    })
    .catch((e) => {
      console.log(e);
    });

  return result;
}
