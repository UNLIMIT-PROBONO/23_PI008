import React, { useEffect, useState } from "react";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { MainHomeTemplate } from "./templates/MainHomeTemplate";
import { getAfterTodaysSchedules } from "../services/ScheduleService";

export function MainHomePage(props) {
  var [data, setData] = useState({});
  var [loading, setLoading] = useState(true);

  async function fetchDangerousTargetsUsage() {
    data["dangerousTargetUsage"] = {};
  }

  async function fetchAfterTodaysSchedules() {
    const afterTodaysSchedules = await getAfterTodaysSchedules();
    data["afterTodaysSchedules"] = afterTodaysSchedules;
  }

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
}
