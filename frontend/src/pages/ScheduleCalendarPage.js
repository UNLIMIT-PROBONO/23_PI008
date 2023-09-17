import React, { useEffect, useState } from "react";
import { ScheduleCalendarTemplate } from "./templates/ScheduleCalendarTemplate";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { getScheduleOfMonth, getScheduleOfThisWeek } from "../services/ScheduleService";

export const ScheduleCalendarPage = (props) => {
  var [loading, setLoading] = useState(true);
  var [data, setData] = useState({
    scheduleOfMonth:[],
    scheduleOfThisWeek:[],
  });
  var [selectedMonth, setSelectedMonth] = useState(new Date());

  const fetchCalendar = async () => {
    data.scheduleOfMonth = await getScheduleOfMonth(
      selectedMonth.getFullYear(),
      selectedMonth.getMonth() + 1
    );
  };

  const fetchThisWeek = async () => {
    data.scheduleOfThisWeek = await getScheduleOfThisWeek();    
  } 

  useEffect(() => {
    setLoading(true);
    const loadData = async () => {
      fetchCalendar();
      fetchThisWeek();
    }

    loadData();
    setLoading(false);
  }, []);

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame content={() => <ScheduleCalendarTemplate data={data} />} />
      )}
    </>
  );
};
