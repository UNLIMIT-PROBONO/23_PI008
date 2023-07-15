import React from "react";
import { UsageBarChart } from "../../molecules/management-target/UsageBarChart";
import { SoundFilled } from "@ant-design/icons";

export function MainBarChart(props) {
  const managementTargets = props.managementTargets;

  const groupMode = "linear";
  const chartKeys = ["call", "water", "elec"]; // 이름
  const chartData = [
    {
      id: "이름",
      call: 123,
      water: 34,
      elec: 31,
    },
    {
      id: "이름dfdf",
      call: 3,
      water: 411,
      elec: 31,
    },
    {
      id: "이름222",
      call: 6,
      water: 99,
      elec: 567,
    },
  ]; // 사용량

  return (
    <>
      <UsageBarChart
        data={chartData}
        keys={chartKeys}
        groupMode={groupMode}
        showLegends={true}
      />
    </>
  );
}
