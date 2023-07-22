import React from "react";
import { Text } from "../../atoms/Text";
import { Col, Row } from "antd";

export const Information = (props) => {
  return (
    <Row>
      <Col>
        <Text label={props.label} />
      </Col>
      <Col>
        <Text label={props.content} />
      </Col>
    </Row>
  );
};
