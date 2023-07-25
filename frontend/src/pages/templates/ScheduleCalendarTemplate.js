import React from "react";
import { TgtCalendar } from "../../components/molecules/calendar/TgtCalendar";
import { WeekSchedule } from "../../components/organisms/calendar/WeekSchedule";

export const ScheduleCalendarTemplate = (props) => {
  const scheduleOfMonth = props.scheduleOfMonth;
  const scheduleOfThisWeek = props.scheduleOfThisWeek;

  return (
    <>
      <TgtCalendar schedules={scheduleOfMonth} />
      <WeekSchedule schedules={scheduleOfThisWeek} />
    </>
  );
};
