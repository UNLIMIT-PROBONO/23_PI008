import { Col, Row } from "antd";
import React from "react";
import { ScheduleList } from "../../molecules/calendar/ScheduleList";
import { classifyTodays } from "../../../services/ScheduleService";

export const WeekSchedule = (props) => {
  // const thisWeekSchedule = props.schedules;
  const thisWeekSchedule = [
    {
      startDate : new Date(2023,7,4),
      endDate : new Date(2023, 7,27),
    },
    {
      startDate : new Date(2023,7,23),
      endDate : new Date(2023, 7,23),
    },
    {
      startDate : new Date(2023,8,14),
      endDate : new Date(2023,8,16),
    },
    {
      startDate : new Date(2023,7,26),
      endDate : new Date(2023, 7,27),
    },
  ];
  const todaySchedule = classifyTodays(thisWeekSchedule);


  return (
    <Row>
      <Col>
        <ScheduleList label="Today" data={todaySchedule} />
      </Col>
      <Col>
        <ScheduleList label="This Week" data={thisWeekSchedule} />
      </Col>
    </Row>
  );
};
