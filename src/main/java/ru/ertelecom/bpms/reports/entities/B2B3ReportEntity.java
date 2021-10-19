package ru.ertelecom.bpms.reports.entities;

import java.util.Date;

public class B2B3ReportEntity {
    private final int isId = 3;
    private final String isName = "BPMS";
    private int cityId;
    private String projectManagerName;
    private final String pmPosition = "ПМ";
    private final String salesChannel = "";
    private int clientId;
    private String clientName;
    private int contractId;
    private String contractType;
    private int requestId;
    private String product; // он же - Услуга
    private final String processName = "Подключение b2b";
    private int connectionPlan; // он же - Схема подключения
    private String processStepName;
    private int processStepId;
    private Date processStepStartDate;
    private Date processStepCompletionDate;
    private String executor;
    private Date planConnectionDate;

    public B2B3ReportEntity(int cityId, String projectManagerName, int clientId, String clientName, int contractId, String contractType, int requestId, String product, int connectionPlan, String processStepName, int processStepId, Date processStepStartDate, Date processStepCompletionDate, String executor, Date planConnectionDate) {
        this.cityId = cityId;
        this.projectManagerName = projectManagerName;
        this.clientId = clientId;
        this.clientName = clientName;
        this.contractId = contractId;
        this.contractType = contractType;
        this.requestId = requestId;
        this.product = product;
        this.connectionPlan = connectionPlan;
        this.processStepName = processStepName;
        this.processStepId = processStepId;
        this.processStepStartDate = processStepStartDate;
        this.processStepCompletionDate = processStepCompletionDate;
        this.executor = executor;
        this.planConnectionDate = planConnectionDate;
    }

    public B2B3ReportEntity() {
    }

    public int getIsId() {
        return isId;
    }

    public String getIsName() {
        return isName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public String getPmPosition() {
        return pmPosition;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProcessName() {
        return processName;
    }

    public int getConnectionPlan() {
        return connectionPlan;
    }

    public void setConnectionPlan(int connectionPlan) {
        this.connectionPlan = connectionPlan;
    }

    public String getProcessStepName() {
        return processStepName;
    }

    public void setProcessStepName(String processStepName) {
        this.processStepName = processStepName;
    }

    public int getProcessStepId() {
        return processStepId;
    }

    public void setProcessStepId(int processStepId) {
        this.processStepId = processStepId;
    }

    public Date getProcessStepStartDate() {
        return processStepStartDate;
    }

    public void setProcessStepStartDate(Date processStepStartDate) {
        this.processStepStartDate = processStepStartDate;
    }

    public Date getProcessStepCompletionDate() {
        return processStepCompletionDate;
    }

    public void setProcessStepCompletionDate(Date processStepCompletionDate) {
        this.processStepCompletionDate = processStepCompletionDate;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Date getPlanConnectionDate() {
        return planConnectionDate;
    }

    public void setPlanConnectionDate(Date planConnectionDate) {
        this.planConnectionDate = planConnectionDate;
    }
}
