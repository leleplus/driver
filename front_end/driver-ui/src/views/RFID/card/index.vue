<template>
    <div class="app-container">
        <!-- 筛选区 -->
        <el-form :model="queryParams" ref="queryForm" :inline="true">
            <el-form-item label="卡片颜色" prop="roleKey">
                <el-input v-model="queryParams.color" placeholder="请输入颜色" clearable size="small" style="width: 240px" @keyup.enter.native="handleQuery"/>
            </el-form-item>
            <el-form-item label="删除标识" prop="status">
                <el-select v-model="queryParams.status" placeholder="请选择删除标识" clearable size="small" style="width: 240px">
                    <el-option v-for="dict in statusOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue"/>
                </el-select>
            </el-form-item>
            <el-form-item label="创建时间">
                <el-date-picker v-model="dateRange" size="small" style="width: 240px" value-format="yyyy-MM-dd" type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <!-- 操作按钮区 -->
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['system:role:add']">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="success" icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate" v-hasPermi="['system:role:edit']">修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete" v-hasPermi="['system:role:remove']">删除</el-button></el-col><el-col :span="1.5"><el-button type="warning" icon="el-icon-download" size="mini" @click="handleExport" v-hasPermi="['system:post:export']">导出</el-button></el-col></el-row>

        <!-- 列表数据显示 -->
        <el-table v-loading="loading" :data="RFIDList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center"/>
            <el-table-column label="编号" prop="id" width="120"/>
            <el-table-column label="卡号" prop="phyNumber" :show-overflow-tooltip="true" width="150"/>
            <el-table-column label="颜色" prop="color" :show-overflow-tooltip="true" width="150"/>
            <el-table-column label="尺寸" prop="size" width="100"/>
            <el-table-column label="类型" prop="type" width="100"/>
            <el-table-column label="创建类型" prop="isNew" width="100"/>
            <el-table-column label="删除标识" align="center" width="100">
                <template slot-scope="scope">
                    <el-switch v-model="scope.row.delete" active-value="0" inactive-value="1" @change="handleStatusChange(scope.row)"></el-switch>
                </template>
            </el-table-column>
            <el-table-column label="创建时间" align="center" prop="createTime" width="180">
                <template slot-scope="scope">
                    <span>{{ parseTime(scope.row.createTime) }}</span>
                </template>
            </el-table-column>
            <el-table-column label="备注" prop="remark" width="100"/>
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:role:edit']">修改</el-button>
                    <!--                <el-button-->
                    <!--                        size="mini"-->
                    <!--                        type="text"-->
                    <!--                        icon="el-icon-circle-check"-->
                    <!--                        @click="handleDataScope(scope.row)"-->
                    <!--                        v-hasPermi="['system:role:edit']"-->
                    <!--                >数据权限-->
                    <!--                </el-button>-->
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['system:role:remove']">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <pagination v-show="RFIDTotal>0" :total="RFIDTotal" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" @pagination="loadRFID"/>
    </div>
</template>

<script>
    import {listRFID} from '@/api/system/rfid'

    export default {
        name: "RFIDCard",
        data() {
            return {
                // 遮罩层
                loading: true,
                // RFID卡片数据
                RFIDList: [],
                // 计数
                RFIDTotal: 0,
                // 选中数组
                ids: [],
                // 非单个禁用
                single: true,
                // 非多个禁用
                multiple: true,
                // 查询参数
                queryParams: {
                    pageNum: 1,
                    pageSize: 10,
                    roleName: undefined,
                    roleKey: undefined,
                    status: undefined
                },
            }
        },
        created() {
            this.loadRFID();
        },
        methods: {
            loadRFID() {
                listRFID({}).then(response => {
                    this.RFIDList = response.rows;
                    this.RFIDTotal = response.total;
                    this.loading = false;
                });
            },
            // 多选框选中数据
            handleSelectionChange(selection) {
                this.ids = selection.map(item => item.id)
                this.single = selection.length != 1
                this.multiple = !selection.length
            },
        }
    }
</script>

<style scoped>

</style>
