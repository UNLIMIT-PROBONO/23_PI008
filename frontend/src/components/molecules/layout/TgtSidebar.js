import {
  BarChartOutlined,
  BarsOutlined,
  HomeOutlined,
  ScheduleOutlined,
  TeamOutlined,
  UserOutlined,
} from "@ant-design/icons";
import { Menu, theme } from "antd";
import Sider from "antd/es/layout/Sider";
import React from "react";

export function TgtSidebar(props) {
  var collapsed = props.collapsed;
  const {
    token: { colorBgContainer },
  } = theme.useToken();

  const sideItems = [
    {
      key: "home",
      icon: <HomeOutlined />,
      label: "메인",
    },
    {
      key: "schedule",
      icon: <ScheduleOutlined />,
      label: "일정",
    },
    {
      key: "target",
      icon: <TeamOutlined />,
      label: "관리 대상자",
      children: [
        {
          key: "target-all",
          icon: <BarsOutlined />,
          label: "전체 보기",
        },
        {
          key: "target-statistic",
          icon: <BarChartOutlined />,
          label: "통계",
        },
      ],
    },
    {
      key: "my-page",
      icon: <UserOutlined />,
      label: "내 정보",
    },
  ];

  return (
    <div>
      <Sider
        trigger={null}
        collapsible
        collapsed={collapsed}
        style={{ height: "100%" }}
      >
        <div className="demo-logo-vertical" />
        <Menu mode="inline" defaultSelectedKeys={["1"]} items={sideItems} />
      </Sider>
    </div>
  );
}
