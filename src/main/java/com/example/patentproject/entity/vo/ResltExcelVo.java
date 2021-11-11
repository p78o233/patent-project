package com.example.patentproject.entity.vo;
/*
 * @author p78o2
 * @date 2021/11/9
 */

public class ResltExcelVo {
//    公司名
    public String companyName;
//    发明授权
    public int inventionAuthorizationNum;
//    发明申请-有效
    public int inventionApplicationValid;
//    发明申请-审中
    public int inventionApplicationPending;
//    发明申请-PCT-有效期内
    public int inventionApplicationPCT;
//    实用新型
    public int utilityModel;
//    短期专利
    public int shortTermPatent;
//    外观设计
    public int appearanceDesign;
//    被引证次数
    public int numberOfCitations;
//    许可次数
    public int licensesNum;
//    转让次数
    public int transfersNum;

    public ResltExcelVo() {
    }

    @Override
    public String toString() {
        return "ResltExcelVo{" +
                "companyName='" + companyName + '\'' +
                ", inventionAuthorizationNum=" + inventionAuthorizationNum +
                ", inventionApplicationValid=" + inventionApplicationValid +
                ", inventionApplicationPending=" + inventionApplicationPending +
                ", inventionApplicationPCT=" + inventionApplicationPCT +
                ", utilityModel=" + utilityModel +
                ", shortTermPatent=" + shortTermPatent +
                ", appearanceDesign=" + appearanceDesign +
                ", numberOfCitations=" + numberOfCitations +
                ", licensesNum=" + licensesNum +
                ", transfersNum=" + transfersNum +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getInventionAuthorizationNum() {
        return inventionAuthorizationNum;
    }

    public void setInventionAuthorizationNum(int inventionAuthorizationNum) {
        this.inventionAuthorizationNum = inventionAuthorizationNum;
    }

    public int getInventionApplicationValid() {
        return inventionApplicationValid;
    }

    public void setInventionApplicationValid(int inventionApplicationValid) {
        this.inventionApplicationValid = inventionApplicationValid;
    }

    public int getInventionApplicationPending() {
        return inventionApplicationPending;
    }

    public void setInventionApplicationPending(int inventionApplicationPending) {
        this.inventionApplicationPending = inventionApplicationPending;
    }

    public int getInventionApplicationPCT() {
        return inventionApplicationPCT;
    }

    public void setInventionApplicationPCT(int inventionApplicationPCT) {
        this.inventionApplicationPCT = inventionApplicationPCT;
    }

    public int getUtilityModel() {
        return utilityModel;
    }

    public void setUtilityModel(int utilityModel) {
        this.utilityModel = utilityModel;
    }

    public int getShortTermPatent() {
        return shortTermPatent;
    }

    public void setShortTermPatent(int shortTermPatent) {
        this.shortTermPatent = shortTermPatent;
    }

    public int getAppearanceDesign() {
        return appearanceDesign;
    }

    public void setAppearanceDesign(int appearanceDesign) {
        this.appearanceDesign = appearanceDesign;
    }

    public int getNumberOfCitations() {
        return numberOfCitations;
    }

    public void setNumberOfCitations(int numberOfCitations) {
        this.numberOfCitations = numberOfCitations;
    }

    public int getLicensesNum() {
        return licensesNum;
    }

    public void setLicensesNum(int licensesNum) {
        this.licensesNum = licensesNum;
    }

    public int getTransfersNum() {
        return transfersNum;
    }

    public void setTransfersNum(int transfersNum) {
        this.transfersNum = transfersNum;
    }

    public ResltExcelVo(String companyName, int inventionAuthorizationNum, int inventionApplicationValid, int inventionApplicationPending, int inventionApplicationPCT, int utilityModel, int shortTermPatent, int appearanceDesign, int numberOfCitations, int licensesNum, int transfersNum) {
        this.companyName = companyName;
        this.inventionAuthorizationNum = inventionAuthorizationNum;
        this.inventionApplicationValid = inventionApplicationValid;
        this.inventionApplicationPending = inventionApplicationPending;
        this.inventionApplicationPCT = inventionApplicationPCT;
        this.utilityModel = utilityModel;
        this.shortTermPatent = shortTermPatent;
        this.appearanceDesign = appearanceDesign;
        this.numberOfCitations = numberOfCitations;
        this.licensesNum = licensesNum;
        this.transfersNum = transfersNum;
    }
}
