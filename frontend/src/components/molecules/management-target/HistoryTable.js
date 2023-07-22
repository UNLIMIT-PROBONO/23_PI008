import { Table } from "antd";
import React from "react";
import { dateFormatting } from "../../../mapper/simpleMapper";

export const HistoryTable = (props) => {
  const dataSource = props.history;

  // 일시, 제목, 상세 내용 , 수행여부(Activated)
  const colums = [
    {
      title: "일시",
      dataIndex: "startDate",
      key: "startDate",
      render: (startDate) => {
        return dateFormatting(startDate);
      },
    },
    {
      title: "내용",
      dataIndex: "title",
      key: "title",
    },
    {
      title: "상세",
      dataIndex: "content",
      key: "content",
    },
    {
      title: "수행 여부",
      dataIndex: "activated",
      key: "activated",
      render: (activated) => {
        return activated === "ACTIVATED" ? "Y" : "N";
      },
    },
  ];

  return (
    <>
      <Table dataSource={dataSource} columns={colums} />
    </>
  );
};
