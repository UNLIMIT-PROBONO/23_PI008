import React, { useEffect, useState } from "react";
import { ScheduleCalendarTemplate } from "./templates/ScheduleCalendarTemplate";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import {
  getScheduleOfMonth,
  getScheduleOfThisWeek,
} from "../services/ScheduleService";

export const ScheduleCalendarPage = (props) => {
  const [loading, setLoading] = useState(true);
  const [scheduleOfMonth, setScheduleOfMonth] = useState([]);
  const [scheduleOfThisWeek, setScheduleOfThisWeek] = useState([]);
  const [selectedMonth, setSelectedMonth] = useState(new Date());

  const fetchCalendar = async () => {
    const result = await getScheduleOfMonth(
      selectedMonth.getFullYear(),
      selectedMonth.getMonth() + 1
    );
    setScheduleOfMonth(result);
  };

  const fetchThisWeek = async () => {
    const result = await getScheduleOfThisWeek();
    setScheduleOfThisWeek(result);
  };

  useEffect(() => {
    setLoading(true);
    const loadData = async () => {
      fetchCalendar();
      fetchThisWeek();
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
            <ScheduleCalendarTemplate
              scheduleOfMonth={scheduleOfMonth}
              scheduleOfThisWeek={scheduleOfThisWeek}
            />
          )}
        />
      )}
    </>
  );
};
