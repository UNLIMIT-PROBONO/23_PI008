import React from "react";
import { SimpleSchedule } from "../../molecules/main-home/SimpleSchedule";
import { Text } from "../../atoms/Text";
import { Col, Divider, Row } from "antd";

export const AfterTodaysSchedule = (props) => {
  const data = props.data;

  return (
    <>
      <Row>
        <Text label={"오늘의 스케줄"} />
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
    </>
  );
};
