import React from 'react';
import { returnComparisonRatio } from '../../../services/TargetService';
import { ResponsiveBar } from '@nivo/bar';

export function UsageBarChart(props) {
  var showLegends = props.showLegends;
  const keys = props.keys;
  const data = props.data;

  var ratio = returnComparisonRatio(props.value, props.weekAvg);
  var color = (ratio > 0) ? "blue" : "red";
  var tag = "오늘 사용량 : " + props.value + " / 전주 사용량 평균 : " + props.weekAvg;

  return (
    <div style={{ width: 350, height: 300 }}>
      <ResponsiveBar
        data={data}
        keys={keys}
        margin={{ top: 50, right: 130, bottom: 50, left: 60 }}
        padding={0.3}
        groupMode={props.groupMode}
        valueScale={{ type: 'linear' }}
        indexScale={{ type: 'band', round: true }}
        axisTop={null}
        axisRight={null}
        axisBottom={{
          tickSize: 5,
          tickPadding: 5,
          tickRotation: 0,
          legend: "",
          legendPosition: "middle",
          legendOffset: 32
        }}
        axisLeft={{
          tickSize: 5,
          tickPadding: 5,
          tickRotation: 0,
          legend: "사용량",
          legendPosition: "middle",
          legendOffset: -40
        }}
        legends={(showLegends) ? [
          {
            dataFrom: 'keys',
            anchor: 'top-right',
            direction: 'column',
            justify: false,
            translateX: 0,
            translateY: 90,
            itemsSpacing: 2,
            itemWidth: 100,
            itemHeight: 20,
            itemDirection: 'left-to-right',
            itemOpacity: 0.85,
            symbolShape: 'diamond',
            symbolSize: 20,
            effects: [
              {
                on: 'hover',
                style: {
                  itemOpacity: 1,
                },
              },
            ],
          }
        ] : []}
        animate={true}
        colors={{ scheme: 'nivo' }}

      />
    </div>
  )
}
// axis 축, legend 라벨(?), data 차트 값,