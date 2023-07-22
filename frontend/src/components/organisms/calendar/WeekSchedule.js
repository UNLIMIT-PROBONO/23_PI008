import { Col, Row } from "antd";
import React from "react";
import { ScheduleList } from "../../molecules/calendar/ScheduleList";

export const WeekSchedule = (props) => {
  const schedules = props.schedules;
  const todaySchedule = props.todaySchedule;
  const thisWeekSchedule = props.thisWeekSchedule;

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
