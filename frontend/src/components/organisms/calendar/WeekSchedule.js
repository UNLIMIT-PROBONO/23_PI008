import { Col, Row } from "antd";
import React from "react";
import { ScheduleList } from "../../molecules/calendar/ScheduleList";
import { classifyTodays } from "../../../services/ScheduleService";

export const WeekSchedule = (props) => {
  const thisWeekSchedule = props.schedules;
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
