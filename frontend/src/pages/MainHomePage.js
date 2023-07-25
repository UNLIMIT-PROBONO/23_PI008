import React, { useEffect, useState } from "react";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { MainHomeTemplate } from "./templates/MainHomeTemplate";
import { getAfterTodaysSchedules } from "../services/ScheduleService";

export const MainHomePage = (props) => {
  var [data, setData] = useState({});
  var [loading, setLoading] = useState(true);

  const fetchDangerousTargetsUsage = async () => {
    // TODO 위험한 대상자들 api
    data["dangerousTargetUsage"] = {};
  };

  const fetchAfterTodaysSchedules = async () => {
    const afterTodaysSchedules = await getAfterTodaysSchedules();
    data["afterTodaysSchedules"] = afterTodaysSchedules;
  };

  var fetchData = () => {
    fetchAfterTodaysSchedules();
    fetchDangerousTargetsUsage();
  };

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
        <BasicFrame content={() => <MainHomeTemplate data={data} />} />
      )}
    </>
  );
};
