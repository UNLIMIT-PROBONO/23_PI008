import React, { useState } from "react";
import { ScheduleCalendarTemplate } from "./templates/ScheduleCalendarTemplate";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { getScheduleOfMonth } from "../services/ScheduleService";

export const ScheduleCalendarPage=(props)=> {
  var [loading, setLoading] = useState(false);
  var [data, setData] = useState({});
  var [selectedMonth, setSelectedMonth] = useState(new Date());

  const fetchCalendar = async () => {
    await getScheduleOfMonth()
  }

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame content={() => <ScheduleCalendarTemplate data={data} />} />
      )}
    </>
  );
}
