import React, { useState } from "react";
import { ScheduleCalendarTemplate } from "./templates/ScheduleCalendarTemplate";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { getScheduleOfMonth, getScheduleOfThisWeek } from "../services/ScheduleService";

export const ScheduleCalendarPage = (props) => {
  var [loading, setLoading] = useState(false);
  var [data, setData] = useState({});
  var [selectedMonth, setSelectedMonth] = useState(new Date());

  const fetchCalendar = async () => {
    var month = await getScheduleOfMonth(
      selectedMonth.getFullYear(),
      selectedMonth.getMonth + 1
    );

    var thisWeek = await getScheduleOfThisWeek();

    data["scheduleOfMonth"] = month;
    data["scheduleOfThisWeek"] = thisWeek;
  };


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
