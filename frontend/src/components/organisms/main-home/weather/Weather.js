import { Row } from "antd";
import React from "react";

export const Weather = (props) => {
  const data = props.data;

  return (
    <>
      <Row>
        <h3>오늘의 날씨</h3>
        <image imgSrc={data.imgSrc} />
      </Row>
      <Row>
        <h4>서울특별시</h4>
      
        <p>현재온도: {Math.round(data.temp - 273.15)}°C</p>
        <p>최고 기온: {Math.round(data.tempMax - 273.15)}°C</p>
        <p>최저 기온: {Math.round(data.tempMin - 273.15)}°C</p>
      </Row>
    </>
  );
};
