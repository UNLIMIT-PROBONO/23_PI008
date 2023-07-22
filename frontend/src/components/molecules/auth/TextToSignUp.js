import React from "react";
import { HrefText, Text } from "../../atoms/Text";
import { Col, Row } from "antd";

export const TextToSignUp = () => {
  return (
    <Row>
      <Col>
        <Text label="회원이 아니십니까?" />
      </Col>
      <Col>
        <HrefText label="회원가입 하기" />
      </Col>
    </Row>
  );
}
