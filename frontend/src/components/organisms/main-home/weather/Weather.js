import { Divider, Row, Space } from "antd";
import React from "react";
import { Text } from "../../../atoms/Text";
import styled from "styled-components";

export const Weather = (props) => {
  const data = props.data;

  return (
    <Conatainer>
      <Row>
        <Text label={"오늘의 날씨"} fontSize={"24px"} />
      </Row>
      <Row>
        <Text label={"서울특별시"} fontSize={"20px"} />
        <Divider><img src={data.imgSrc} /></Divider>

        <Text label={`현재 온도: ${data.temp} °C`} />
        <Text label={`최고 기온: ${data.tempMax} °C`} />
        <Text label={`최저 기온: ${data.tempMin} °C`} />
        <Text label={`습도 : ${data.humidity} %`} />
      </Row>
    </Conatainer>
  );
};

const Conatainer = styled.div`
  width: 35vw;
  background: #FDFDFD;
  margin: 10px;
  padding: 20px;
  border-radius: 15px;
`;