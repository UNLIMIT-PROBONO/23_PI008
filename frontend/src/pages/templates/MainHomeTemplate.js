import React from "react";
import { MainBarChart } from "../../components/organisms/main-home/MainBarChart";
import { Col, Row } from "antd";
import { AfterTodaysSchedule } from "../../components/organisms/main-home/AfterTodaysSchedule";

export function MainHomeTemplate(props) {
  const dangerousTargetUsage = props.dangerousTargetUsage;
  const afterTodaysSchedules = props.afterTodaysSchedules;

  return (
    <>
      <Row>
        <Col>
          <MainBarChart data={dangerousTargetUsage} />
        </Col>
      </Row>
      <Row>
        <Col>
          <AfterTodaysSchedule data={afterTodaysSchedules} />
        </Col>
      </Row>
    </>
  );
}
