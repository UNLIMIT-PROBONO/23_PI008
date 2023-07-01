// react object name : json name
export function jsonToTargetInfomation(data){
    return {
        "targetId": data.user_id,
        "tgName": data.name,
        "phoneNumber": data.phone_number,
        "address": data.address,
        "birth": jsonToDatetime(data.birth),
        "gender": data.gender,
        "health": data.health,
        "check": data.check,
        "createdAt": jsonToDatetime(data.created_at),
        "updatedAt": jsonToDatetime(data.updated_at),
    };
}

export function jsonToHistoryOfSchedule(data){
    return data.map(d => mapToScheduleObject(d));
}

function mapToScheduleObject(data) {
    return {
        "scheduleId" : data.schedule_id,
        "title": data.title,
        "content": data.content,
        "startDate": jsonToDatetime(data.start_date),
        "endDate": jsonToDatetime(data.end_date),
        "createdAt": jsonToDatetime(data.created_at),
        "updatedAt": jsonToDatetime(data.updated_at),
        "activated": data.activated,
    }
}

export function jsonToUsageForm(data){
    return {
        "today": jsonToDatetime(data.date),
        "call": [
            {
                "id": "call",
                "todayUsage": data.call,
                "weekAvg": data.call_avg,
            }
        ],
        "water": [
            {
                "id": "water",
                "todayUsage": data.water,
                "weekAvg": data.water_avg,
            }
        ],
        "elec": [
            {
                "id": "elec",
                "todayUsage": data.elec,
                "weekAvg": data.elec_avg,
            }
        ]
    };
}

function jsonToDatetime(str){
    return new Date(str);
}