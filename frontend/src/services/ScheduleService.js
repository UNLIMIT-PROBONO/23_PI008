import { jsonArrayToSchedule } from "../mapper/scheduleMapper";
import RestAPI from "../utils/AxiosApi";
import { URI } from "../utils/config";

export const getAfterTodaysSchedules = async () => {
  const result = await RestAPI.get(URI.SCHEDULE)
    .then((res) => {
      if (res.status === 200) {
        return res.data;
      }
    })
    .catch((e) => console.log(e));
  return result;
};

export const getHistoryOfSchedule = async (targetId) => {
  var result = await RestAPI.get(URI.SCHEDULE_HISTORY, {
    params: {
      userId: targetId,
    },
  })
    .then((res) => {
      if (res.status === 200) {
        return jsonArrayToSchedule(res.data);
      }
    })
    .catch((e) => {
      return [];
    });

  return result;
};

export const getScheduleOfMonth = async (year, month) => {
  var result = await RestAPI.get(URI.CALENDAR, {
    params: {
      year: year,
      month: month,
    },
  })
    .then((res) => {
      if (res.status === 200) {
        return jsonArrayToSchedule(res.data);
      }
    })
    .catch((e) => {
      console.log(e);
      return [];
    });

  return result;
};

export const getScheduleOfThisWeek = async () => {
  return await RestAPI.get(URI.THIS_WEEK)
    .then((res) => {
      if (res.status === 200) {
        return jsonArrayToSchedule(res.data);
      }
    })
    .catch((e) => {
      console.log(e);
      return [];
    });
};

export const classifyTodays = (schedules) => {
  var today = new Date();
  return schedules.filter((s) => s.startDate <= today && s.endDate >= today);
};

export const addNewSchedule = async (data) => {
    return await RestAPI.post(URI.SCHEDULE, data)
    .then((res) => {
      if(res.status === 200) {
        return true;
      }
    })
    .catch((e)=>{
      return false;
    });
}
