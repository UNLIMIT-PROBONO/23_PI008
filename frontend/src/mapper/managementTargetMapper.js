import { jsonToDatetime } from "./simpleMapper";

// react object name : json name
export const jsonToTargetInfomation = (data) => {
  return {
    targetId: data.userId,
    tgName: data.name,
    phoneNumber: data.phoneNumber,
    address: data.address,
    birth: jsonToDatetime(data.birth),
    gender: data.gender,
    health: data.health,
    check: data.check,
    createdAt: jsonToDatetime(data.createdAt),
    updatedAt: jsonToDatetime(data.updatedAt),
  };
};

export const jsonToAllTaregetInfomation = (jsonArray) => {
  return jsonArray.map((json) => jsonToTargetInfomation(json));
};

export const jsonToUsageForm = (data) => {
  return {
    today: jsonToDatetime(data.date),
    call: [
      {
        id: "call",
        todayUsage: data.call,
        weekAvg: data.callAvg,
      },
    ],
    water: [
      {
        id: "water",
        todayUsage: data.water,
        weekAvg: data.waterAvg,
      },
    ],
    elec: [
      {
        id: "elec",
        todayUsage: data.elec,
        weekAvg: data.elecAvg,
      },
    ],
  };
};
