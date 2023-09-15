import React from "react";
import { Information } from "../../molecules/management-target/Information";
import { Col, Row } from "antd";
import { Age } from "../../molecules/management-target/Age";

export const PrivacyInformation = (props) => {
  const data = props.data;

  return (
    <>
      <Row>
        <Col>
          <Information content={data.tgName} />
        </Col>
        <Col>
          <Age birth={data.birth} age={data.age} />
        </Col>
      </Row>
      <Row>
        <Information label="주소 : " content={data.address} />
      </Row>
      <Row>
        <Information label="번호 : " content={data.phoneNumber} />
      </Row>
    </>
  );
};
