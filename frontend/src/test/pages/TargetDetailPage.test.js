/*
js 테스트 용 데이터들

// 관리 대상자 정보
jsonToTargetInfomation({
        "userId" : 123,
        "adminId" : 111,
        "name" : "john",
        "phoneNumber" : "01011113333",
        "address" : "경기도 부천시",
        "gender" : "FEMALE",
        "birth" : new Date(2000,2,4),
        "health" : "고혈압, 당료", //  enum 리스트로 표현되면 좋은데
        "check" : "특이사항(하루 1번 복용)",
        "createdAt" : new Date(2000,2,4),
        "updatedAt" : new Date(2000,2,4),
    });

// 관리 대상자 사용량 정보
jsonToUsageForm({
        "userId": 1,
          "call": 2,
          "callAvg" : 3,
          "water": 2331,
          "waterAvg" : 2445,
          "elec" : 1349,
          "elecAvg" : 1342,
          "date" : new Date(2021, 3, 5)
      });

// 최근 관리 내역
jsonToHistoryOfSchedule([
    {
    "scheduleId": 1,
    "title": "제목",
      "content" : "전화 드리기",
      "startDate" : new Date(2000,2,4),
      "endDate" : new Date(2000,2,4),
    "createdAt": new Date(2000,2,4),
    "updatedAt": new Date(2000,2,4),
      "activated": "ACTIVATED" // enum이라 바뀔 수도?
    },
    {
    "scheduleId": 1123,
    "title": "dsdfsdfs",
      "content" : "내용 드리기",
      "startDate" : new Date(1999,2,4),
      "endDate" : new Date(1234,2,4),
    "createdAt": new Date(2023,2,4),
    "updatedAt": new Date(2011,2,4),
      "activated": "DEACTIVATE" // enum이라 바뀔 수도?
    },
    {
    "scheduleId": 2,
    "title": "제목",
      "content" : "내요요요요요오오오오옹"",
      "startDate" : new Date(1923,2,4),
      "endDate" : new Date(1999,2,4),
    "createdAt": new Date(2013,2,4),
    "updatedAt": new Date(1233,2,4),
      "activated": "DEACTIVATED" // enum이라 바뀔 수도?
    },
    {
    "scheduleId": 14,
    "title": "김씨 할머니 방문",
      "content" : "강아지 조심",
      "startDate" : new Date(2023,2,4),
      "endDate" : new Date(2023,5,4),
    "createdAt": new Date(2123,2,4),
    "updatedAt": new Date(2033,2,4),
      "activated": "ACTIVATED" // enum이라 바뀔 수도?
    },
  ])
*/