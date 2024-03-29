import { Col, Row } from "antd";
import React from "react";
import { UsageBarChart } from "../../molecules/management-target/UsageBarChart";
import { Text } from "../../atoms/Text";

export const UsageComparison = (props) => {
  const data = props.data;
  const groupMode = "grouped";
  const chartKeys = ["todayUsage", "weekAvg"];

  return (
    <>
      <Text label="전주 대비 사용량 증감" fontSize={"24px"}/>
      <Row gutter={[16, 16]}>
        <Col span={"8"}>
          <UsageBarChart
            data={data.call}
            keys={chartKeys}
            groupMode={groupMode}
          />
        </Col>
        <Col span={"8"}>
          <UsageBarChart
            data={data.water}
            keys={chartKeys}
            groupMode={groupMode}
          />
        </Col>
        <Col span={"8"}>
          <UsageBarChart
            data={data.elec}
            keys={chartKeys}
            groupMode={groupMode}
            // showLegends={true}
          />
        </Col>
      </Row>
    </>
  );
};
