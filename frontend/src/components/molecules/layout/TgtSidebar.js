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
import { useNavigate } from "react-router-dom";

export const TgtSidebar = (props) => {
  var collapsed = props.collapsed;
  const router = useNavigate();
  const {
    token: { colorBgContainer },
  } = theme.useToken();

  const sideItems = [
    {
      key: "main",
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
          key: "target",
          icon: <BarsOutlined />,
          label: "전체 보기",
        },
        {
          key: "target/statistic",
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

  const routePage = (path) => {
    router(`../${path}`);
  }

  return (
    <div>
      <Sider
        trigger={null}
        collapsible
        collapsed={collapsed}
        style={{
          height: "100vh",
          left: 0,
          top: 0,
          bottom: 0,
        }}
      >
        <div className="demo-logo-vertical" />
        <Menu
          onClick={({key})=> routePage(key)}
          mode="inline" 
          defaultSelectedKeys={["1"]}
          items={sideItems} 
        />
      </Sider>
    </div>
  );
};
