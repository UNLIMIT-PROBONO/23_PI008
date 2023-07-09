import { Layout } from 'antd';
import React, { useState } from 'react';
import { TgtSidebar } from '../../molecules/layout/TgtSidebar';
import { TgtHeader } from '../../molecules/layout/TgtHeader';

export function BasicFrame(props){
    const [collapsed, setCollapsed] = useState(false);

    return (
        <div>
            <Layout>
                <TgtSidebar 
                    collapsed={collapsed}
                />
                <Layout>
                    <TgtHeader 
                        collapsed={collapsed}  
                        setCollapsed={setCollapsed}  
                    />
                    <Layout>
                        {props.content()}
                    </Layout>
                    {/* Footer */}
                </Layout>
            </Layout>
        </div>
    )
}