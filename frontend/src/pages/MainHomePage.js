import React, { useEffect, useState } from "react";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { MainHomeTemplate } from "./templates/MainHomeTemplate";
import { getAfterTodaysSchedules } from "../services/ScheduleService";
import { getDangerousTargetsUsage } from "../services/DataService";
import { getTodayWeather } from "../services/WeatherService";

export const MainHomePage = () => {
  var [loading, setLoading] = useState(true);
  const [dangerousTargetUsage, setDangerousTargetUsage] = useState([]);
  const [afterTodaysSchedules, setAfterTodaysSchedules] = useState([]);
  const [todaysWeather, setTodaysWeather] = useState({});

  const fetchDangerousTargetsUsage = async () => {
    const result = await getDangerousTargetsUsage()
    setDangerousTargetUsage(result);
  };

  const fetchAfterTodaysSchedules = async () => {
    const result = await getAfterTodaysSchedules();
    setAfterTodaysSchedules(result);
  };

  const fetchCurrentWeather = async () => {
    const result = await getTodayWeather();
    setTodaysWeather(result);
  };

  useEffect(() => {
    setLoading(true);
    const loadData = async () => {
      fetchAfterTodaysSchedules();
      fetchDangerousTargetsUsage();
      fetchCurrentWeather();
    };

    loadData();
    setLoading(false);
  }, []);

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame
          content={() => (
            <MainHomeTemplate
              dangerousTargetUsage={dangerousTargetUsage}
              afterTodaysSchedules={afterTodaysSchedules}
              todaysWeather={todaysWeather}
            />
          )}
        />
      )}
    </>
  );
};
