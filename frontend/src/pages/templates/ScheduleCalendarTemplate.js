import React from "react";
import { TgtCalendar } from "../../components/molecules/calendar/TgtCalendar";
import { WeekSchedule } from "../../components/organisms/calendar/WeekSchedule";

export const ScheduleCalendarTemplate = (props) => {
  const scheduleOfMonth = props.data.scheduleOfMonth;
  const scheduleOfThisWeek = props.data.scheduleOfThisWeek;

  return (
    <>
      <TgtCalendar schedules={scheduleOfMonth} />
      <WeekSchedule schedules={scheduleOfThisWeek} />
    </>
  );
};
