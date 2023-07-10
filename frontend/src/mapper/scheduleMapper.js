import { jsonToDatetime } from "./simpleMapper";

export function jsonToSimpleSchedule(jsonArray) {
    return jsonArray.map(json => mapToSimpleScheduleObject(json));
}

function mapToSimpleScheduleObject(data) {
    return {
        "scheduleId": data.schedulId,
        "tgName": data.userName,
        "content": data.title,
        "activated": data.activated,
    }
}

export function jsonToHistoryOfSchedule(jsonArray) {
    return jsonArray.map(json => mapToScheduleObject(json));
}

function mapToScheduleObject(data) {
    return {
        "scheduleId": data.schedulId,
        "title": data.title,
        "content": data.content,
        "startDate": jsonToDatetime(data.startDate),
        "endDate": jsonToDatetime(data.endDate),
        "createdAt": jsonToDatetime(data.createdAt),
        "updatedAt": jsonToDatetime(data.updatedAt),
        "activated": data.activated,
    }
}