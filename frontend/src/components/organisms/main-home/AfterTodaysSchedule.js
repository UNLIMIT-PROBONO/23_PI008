import React from "react";
import { SimpleSchedule } from "../../molecules/main-home/SimpleSchedule";
import { Text } from "../../atoms/Text";
import { Col, Divider, Row } from "antd";
import styled from "styled-components";

export const AfterTodaysSchedule = (props) => {
  const data = props.data;

  return (
    <Conatainer>
      <Row>
        <Text label={"오늘의 스케줄"} fontSize={"24px"} />
      </Row>
      <Row>
        <Col>
          {data.map((item) => (
            <Row>
              <SimpleSchedule
                index={item.index}
                scheduleId={item.scheduleId}
                title={item.title}
                activated={item.activated}
              />
            </Row>
          ))}
        </Col>
      </Row>
    </Conatainer>
  );
};

const Conatainer = styled.div`
  width: 35vw;
  background: #fdfdfd;
  margin: 10px;
  padding: 20px;
  border-radius: 15px;
`;
