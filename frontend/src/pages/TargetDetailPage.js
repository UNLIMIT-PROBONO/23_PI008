import React, { useEffect, useState } from "react";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { TargetDetailTemplate } from "./templates/TargetDetailTemplate";
import { getTargetInfo } from "../services/TargetService";
import { getHistoryOfSchedule } from "../services/ScheduleService";
import { useParams } from "react-router";
import { getTargetUsage } from "../services/DataService";

export const TargetDetailPage = () => {
  const { targetId } = useParams();
  const [loading, setLoading] = useState(true);

  const [targetInformation, setTargetInformation] = useState({});
  const [targetUsage, setTargetUsage] = useState({
    date: new Date(),
    call: [],
    elec: [],
    water: [],
  });
  const [managementHistory, setManagementHistory] = useState([]);

  const fetchTargetInfomation = async () => {
    const result = await getTargetInfo(targetId);
    if (result) setTargetInformation(result);
  };

  const fetchTargetUsage = async () => {
    const result = await getTargetUsage(targetId);
    if (result) setTargetUsage(result);
  };

  const fetchHistory = async () => {
    const result = await getHistoryOfSchedule(targetId);
    if (result) setManagementHistory(result);
  };

  // 생성한 함수를 컴포넌트가 mount 됐을 때 실행
  useEffect(() => {
    setLoading(true);
    const fetchData = async () => {
      fetchTargetInfomation();
      fetchTargetUsage();
      fetchHistory();
    };

    fetchData();
    setLoading(false);
  }, []);

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame
          content={() => (
            <TargetDetailTemplate
              targetUsage={targetUsage}
              targetInformation={targetInformation}
              managementHistory={managementHistory}
            />
          )}
        />
      )}
    </>
  );
};
