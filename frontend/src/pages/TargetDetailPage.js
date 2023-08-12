import React, { useEffect, useState } from "react";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { TargetDetailTemplate } from "./templates/TargetDetailTemplate";
import { getTargetInfo, getTargetUsage } from "../services/TargetService";
import { getHistoryOfSchedule } from "../services/ScheduleService";

export const TargetDetailPage = (props) => {
  const targetId = props.targetId;
  var [loading, setLoading] = useState(true);
  var [data, setData] = useState({});

  const fetchTargetInfomation = async () => {
    const targetInfo = await getTargetInfo(targetId);
    data["targetInfomation"] = targetInfo;
  };

  const fetchTargetUsage = async () => {
    const targetUsage = await getTargetUsage(targetId);
    data["targetUsage"] = targetUsage;
  };

  const fetchHistory = async () => {
    const history = await getHistoryOfSchedule(targetId);
    data["managementHistory"] = history;
  };

  var fetchData = () => {
    fetchTargetInfomation();
    fetchTargetUsage();
    fetchHistory();
  };

  // 생성한 함수를 컴포넌트가 mount 됐을 때 실행
  useEffect(async () => {
    setLoading(true);
    await fetchData();
    setLoading(false);
  }, []);

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame content={() => <TargetDetailTemplate data={data} />} />
      )}
    </>
  );
};
