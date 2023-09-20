import React from "react";
import logo from "../../assets/togetherLogo.png";
import "../css/Logo.css";
import { Text } from "../atoms/Text";
import { Col, Row } from "antd";

export const TogetherLogo = () => {
  return (
      <Row>
        <img src={logo} width="100px" height="100px" />
        <Col style={{marginLeft:"10px"}}>
          <Row>
            <Text label={"아울러"} fontSize={"36px"} />
          </Row>
          <Row>
            <Text label={"사회복지사의 관리 모니터링"} fontSize={"20px"} />
          </Row>
        </Col>
      </Row>
  );
};
