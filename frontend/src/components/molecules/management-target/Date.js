import { Col, Row } from "antd";
import React from "react";
import { dateFormatting } from "../../../utils/mapper";
import { Text } from "../../atoms/Text";

export const LabeledDate = (props) => {
  const date = (props.date)? props.date : new Date();
  const formatted = dateFormatting(date);
  
  return (
    <Row>
      <Col>
        <Text label={props.label} />
      </Col>
      <Col>
        <Text label={formatted} />
      </Col>
    </Row>
  );
};
