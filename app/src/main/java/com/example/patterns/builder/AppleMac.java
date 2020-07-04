package com.example.patterns.builder;

public class AppleMac extends BaseComputer {

    private String system;

    private AppleMac(AppleMacBuilder builder) {
        super(builder);
        this.system = builder.system;
    }

    public String getSystem() {
        return system;
    }

    public static class AppleMacBuilder extends BaseComputerBuilder<AppleMacBuilder, AppleMac> {

        private String system = "default system";

        public AppleMacBuilder ofSystem(String system) {
            this.system = system;
            return this;
        }

        @Override
        public AppleMac build() {
            return new AppleMac(this);
        }
    }
}
