import { Table } from "antd";
import React from "react";

export const TargetList = (props) => {
  const dataSource = props.sources;

  const colums = [
    {
      title: "이름",
      dataIndex: "tgName",
      key: "tgName",
    },
    {
      title: "나이",
      dataIndex: "age",
      key: "age",
    },
    {
      title: "성별",
      dataIndex: "gender",
      key: "gender",
      render: (gender) => {
        return gender === "MALE" ? "남" : "여";
      },
    },
    {
      title: "연락처",
      dataIndex: "phoneNumber",
      key: "phoneNumber",
    },
    {
      title: "주소",
      dataIndex: "address",
      key: "address",
    },
  ];

  return (
    <>
      <Table
        dataSource={dataSource}
        columns={colums}
        onRow={(record, index) => {
          return {
            onClick: () => props.onClickRow(record.targetId),
          };
        }}
      />
    </>
  );
};
