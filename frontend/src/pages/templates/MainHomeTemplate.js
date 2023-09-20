import React from "react";
import { MainBarChart } from "../../components/organisms/main-home/MainBarChart";
import { Col, Row } from "antd";
import { AfterTodaysSchedule } from "../../components/organisms/main-home/AfterTodaysSchedule";
import { Weather } from "../../components/organisms/main-home/weather/Weather";

export const MainHomeTemplate = (props) => {
  const dangerousTargetUsage = props.dangerousTargetUsage;
  const afterTodaysSchedules = props.afterTodaysSchedules;
  const todaysWeather = props.todaysWeather;

  return (
    <>
      <Row gutter={[16, 16]} align={"middle"}>
        <Col>
          <MainBarChart data={dangerousTargetUsage} />
        </Col>
      </Row>
      <Row gutter={[16, 16]}>
        <Col span={8}>
          <AfterTodaysSchedule data={afterTodaysSchedules} />
        </Col>

        <Col span={8}>
          <Weather data={todaysWeather} />
        </Col>
      </Row>
    </>
  );
};
