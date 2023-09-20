import React from "react";
import { MainBarChart } from "../../components/organisms/main-home/MainBarChart";
import { Col, Row } from "antd";
import { AfterTodaysSchedule } from "../../components/organisms/main-home/AfterTodaysSchedule";
import { Weather } from "../../components/organisms/main-home/weather/Weather";
import styled from "styled-components";

export const MainHomeTemplate = (props) => {
  const dangerousTargetUsage = props.dangerousTargetUsage;
  const afterTodaysSchedules = props.afterTodaysSchedules;
  const todaysWeather = props.todaysWeather;

  return (
    <>
      <Row gutter={[16, 16]}>
        <Col>
          <CenterWrap>
            <MainBarChart data={dangerousTargetUsage} />
          </CenterWrap>
        </Col>
      </Row>
      <Row gutter={[16, 16]} justify={"center"}>
        <Col span={11}>
          <AfterTodaysSchedule data={afterTodaysSchedules} />
        </Col>

        <Col span={11}>
          <Weather data={todaysWeather} />
        </Col>
      </Row>
    </>
  );
};

const CenterWrap = styled.div`
  width: 82.5vw;
  display: flex;
  align-items: center;
  justify-content: center;
`;
