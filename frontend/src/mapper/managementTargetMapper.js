// react object name : json name
export function jsonToTargetInfomation(data) {
    return {
        "targetId": data.userId,
        "tgName": data.name,
        "phoneNumber": data.phoneNumber,
        "address": data.address,
        "birth": jsonToDatetime(data.birth),
        "gender": data.gender,
        "health": data.health,
        "check": data.check,
        "createdAt": jsonToDatetime(data.createdAt),
        "updatedAt": jsonToDatetime(data.updatedAt),
    };
}

export function jsonToHistoryOfSchedule(data) {
    return data.map(d => mapToScheduleObject(d));
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

export function jsonToUsageForm(data) {
    return {
        "today": jsonToDatetime(data.date),
        "call": [
            {
                "id": "call",
                "todayUsage": data.call,
                "weekAvg": data.callAvg,
            }
        ],
        "water": [
            {
                "id": "water",
                "todayUsage": data.water,
                "weekAvg": data.waterAvg,
            }
        ],
        "elec": [
            {
                "id": "elec",
                "todayUsage": data.elec,
                "weekAvg": data.elecAvg,
            }
        ]
    };
}

function jsonToDatetime(str) {
    return new Date(str);
}