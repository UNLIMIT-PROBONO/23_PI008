/*
js 테스트 용 데이터들

// 관리 대상자 정보
jsonToTargetInfomation({
        "user_id" : 123,
        "admin_id" : 111,
        "name" : "john",
        "phone_number" : "01011113333",
        "address" : "경기도 부천시",
        "gender" : "FEMALE",
        "birth" : new Date(2000,2,4),
        "health" : "고혈압, 당료", //  enum 리스트로 표현되면 좋은데
        "check" : "특이사항(하루 1번 복용)",
        "created_at" : new Date(2000,2,4),
        "updated_at" : new Date(2000,2,4),
    });

// 관리 대상자 사용량 정보
jsonToUsageForm({
        "user_id": 1,
          "call": 2,
          "call_avg" : 3,
          "water": 2331,
          "water_avg" : 2445,
          "elec" : 1349,
          "elec_avg" : 1342,
          "date" : new Date(2021, 3, 5)
      });

// 최근 관리 내역
jsonToHistoryOfSchedule([{
        "schedule_id": 1,
        "title": "제목",
          "content" : "전화 드리기",
          "start_date" : new Date(2000,2,4),
          "end_date" : new Date(2000,2,4),
        "created_at": new Date(2000,2,4),
        "updated_at": new Date(2000,2,4),
          "activated": "ACTIVATED" // enum이라 바뀔 수도?
          },
          {
            "schedule_id": 1,
            "title": "제목",
              "content" : "전화 fsdfdfsdfs",
              "start_date" : new Date(2000,2,4),
              "end_date" : new Date(2000,2,4),
            "created_at": new Date(2000,2,4),
            "updated_at": new Date(2000,2,4),
              "activated": "ACTIVATED" // enum이라 바뀔 수도?
            },
            {
            "schedule_id": 1,
            "title": "gkfdlf",
                "content" : "qkdans",
                "start_date" : new Date(2000,2,4),
                "end_date" : new Date(2000,2,4),
            "created_at": new Date(2000,2,4),
            "updated_at": new Date(2000,2,4),
                "activated": "ACTIVATED" // enum이라 바뀔 수도?
        }])
*/